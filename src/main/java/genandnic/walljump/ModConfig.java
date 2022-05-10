package genandnic.walljump;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

import static genandnic.walljump.WallJump.config;


@Config(name = WallJump.MOD_ID)
public class ModConfig implements ConfigData {
        @Comment("Allows you to climb up without alternating walls")
        public boolean allowReclinging = false;

        @Comment("Automatically turn the player when wall clinging")
        public boolean autoRotation = false;

        @Comment("Elytra speed boost; set to 0.0 to disable")
        @ConfigEntry.Gui.RequiresRestart
        public double elytraSpeedBoost = 0.0;

        @Comment("Exhaustion gained per wall jump")
        public double exhaustionWallJump = 0.8;

        @Comment("Minimum distance for fall damage; set to 3.0 to disable")
        public double minFallDistance = 7.5;

        @Comment("Play a rush of wind as you fall to your doom")
        public boolean playFallSound = true;

        @Comment("Sprint speed boost; set to 0.0 to disable")
        @ConfigEntry.Gui.RequiresRestart
        public double sprintSpeedBoost = 0.0;

        @Comment("Walk up steps even while airborne, also jump over fences")
        public boolean stepAssist = true;

        @Comment("Allows you to jump in mid-air; will crash your game inside mod menu if you change it there.")
        @ConfigEntry.Gui.RequiresRestart
        public boolean useDoubleJump = true;

        @Comment("Allows you to wall cling and wall jump")
        @ConfigEntry.Gui.RequiresRestart
        public boolean useWallJump = true;

        @Comment("Height of Wall Jumps")
        public double wallJumpHeight = 0.55;

        @Comment("Ticks wall clinged before starting wall slide")
        public int wallSlideDelay = 20;

        public static ModConfig getConfig() {
                if (config == null) {
                        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
                        config = AutoConfig.getConfigHolder(ModConfig.class);
                }
                return config.getConfig();
        }
}

