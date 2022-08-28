package net.frozenblock.wilderwild.misc.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.frozenblock.wilderwild.WilderWildClient;

import static net.frozenblock.wilderwild.misc.config.WilderWildConfig.text;
import static net.frozenblock.wilderwild.misc.config.WilderWildConfig.tooltip;

@Config(name = "entity")
public class EntityConfig implements ConfigData {

    public static void setupEntries(ConfigCategory category, ConfigEntryBuilder entryBuilder) {
        var config = WilderWildClient.config;
        category.addEntry(entryBuilder.startBooleanToggle(text("warden_emerges_from_egg"), config.wardenEmergesFromEgg)
                .setDefaultValue(true)
                .setSaveConsumer(newValue -> config.wardenEmergesFromEgg = newValue)
                .setTooltip(tooltip("warden_emerges_from_egg"))
                .build());
        category.addEntry(entryBuilder.startBooleanToggle(text("warden_custom_tendrils"), config.customWardenTendrils)
                .setDefaultValue(true)
                .setSaveConsumer(newValue -> config.customWardenTendrils = newValue)
                .setYesNoTextSupplier(bool -> text("warden_custom_tendrils." + bool))
                .setTooltip(tooltip("warden_custom_tendrils"))
                .build());
        category.addEntry(entryBuilder.startBooleanToggle(text("warden_swim_animation"), config.wardenSwimAnimation)
                .setDefaultValue(true)
                .setSaveConsumer(newValue -> config.wardenSwimAnimation = newValue)
                .setTooltip(tooltip("warden_swim_animation"))
                .build());

    }


    //public static final EnumConfigOption<ModMenuConfig.ModsButtonStyle> MODS_BUTTON_STYLE = new EnumConfigOption<>("mods_button_style", ModMenuConfig.ModsButtonStyle.CLASSIC);
    //public static final StringSetConfigOption HIDDEN_MODS = new StringSetConfigOption("hidden_mods", new HashSet<>());
    /*public static EntityConfig init() {
        AutoConfig.register(EntityConfig.class, GsonConfigSerializer::new);
        return AutoConfig.getConfigHolder(EntityConfig.class).getConfig();
    }*/
}
