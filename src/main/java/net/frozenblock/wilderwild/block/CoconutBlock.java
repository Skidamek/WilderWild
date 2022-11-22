package net.frozenblock.wilderwild.block;

import net.frozenblock.wilderwild.registry.RegisterBlocks;
import net.frozenblock.wilderwild.world.gen.sapling.BaobabSaplingGenerator;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public class CoconutBlock extends SaplingBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    public static final int MAX_AGE = 2;
    private static final VoxelShape[] SHAPES = new VoxelShape[]{
            Shapes.or(Block.box(7.0, 13.0, 7.0, 9.0, 16.0, 9.0), Block.box(5.0, 6.0, 5.0, 11.0, 13.0, 11.0)),
            Shapes.or(Block.box(7.0, 12.0, 7.0, 9.0, 16.0, 9.0), Block.box(4.0, 3.0, 4.0, 12.0, 12.0, 12.0)),
            Shapes.or(Block.box(7.0, 10.0, 7.0, 9.0, 16.0, 9.0), Block.box(4.0, 0.0, 4.0, 12.0, 10.0, 12.0)),
            Block.box(7.0, 3.0, 7.0, 9.0, 16.0, 9.0), Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D)
    };
    public static final BooleanProperty HANGING = BlockStateProperties.HANGING;

    public CoconutBlock(Properties settings) {
        super(new BaobabSaplingGenerator(), settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, 0).setValue(AGE, 0).setValue(HANGING, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STAGE, AGE, HANGING);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return Objects.requireNonNull(super.getStateForPlacement(ctx)).setValue(AGE, 2);
    }

    @Override
    public VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Vec3 vec3d = state.getOffset(level, pos);
        VoxelShape voxelShape;
        if (!state.getValue(HANGING)) {
            voxelShape = SHAPES[4];
        } else {
            voxelShape = SHAPES[state.getValue(AGE)];
        }

        return voxelShape.move(vec3d.x, vec3d.y, vec3d.z);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return isHanging(state) ? level.getBlockState(pos.above()).is(RegisterBlocks.BAOBAB_LEAVES) : super.canSurvive(state, level, pos);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!isHanging(state)) {
            if (random.nextInt(7) == 0) {
                this.advanceTree(level, pos, state, random);
            }

        } else {
            if (!isFullyGrown(state)) {
                level.setBlock(pos, state.cycle(AGE), 2);
            }

        }
    }

	@Override
	public boolean isValidBonemealTarget(BlockGetter world, BlockPos pos, BlockState state, boolean isClient) {
		return !isHanging(state) || !isFullyGrown(state);
	}

	@Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return isHanging(state) ? !isFullyGrown(state) : super.isBonemealSuccess(level, random, pos, state);
    }

	@Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if (isHanging(state) && !isFullyGrown(state)) {
            level.setBlock(pos, state.cycle(AGE), 2);
        } else {
            super.performBonemeal(level, random, pos, state);
        }

    }

	@Override
	public void onProjectileHit(Level world, BlockState state, BlockHitResult hit, Projectile projectile) {
		world.destroyBlock(hit.getBlockPos(), true, projectile);
	}

	@Override //Only collision with projectiles so you can shoot them down
	public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		if (collisionContext instanceof EntityCollisionContext entityCollision) {
			if (entityCollision.getEntity() != null) {
				return !(entityCollision.getEntity() instanceof Projectile) ? Shapes.empty() : super.getCollisionShape(blockState, blockGetter, blockPos, collisionContext);
			}
		}
		return Shapes.empty();
	}

    private static boolean isHanging(BlockState state) {
        return state.getValue(HANGING);
    }

    private static boolean isFullyGrown(BlockState state) {
        return state.getValue(AGE) == 2;
    }

    public static BlockState getDefaultHangingState() {
        return getHangingState(0);
    }

    public static BlockState getHangingState(int age) {
        return RegisterBlocks.BAOBAB_NUT.defaultBlockState().setValue(HANGING, true).setValue(AGE, age);
    }
}