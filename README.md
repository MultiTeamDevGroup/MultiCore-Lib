
![MultiCoreLib Logo](https://raw.githubusercontent.com/MultiTeamDevGroup/MultiCore-Lib/main/src/main/resources/multicore_lib_logo.png)
### for Forge 1.20.1 - by MultiTeam

## About
MultiCoreLib is a library mod for several tools and utils, used by most multiteam mods.

## Credits
- LazTheArtist [HoverTextItemTool - ItemGroupTool - ItemManagementTool - MathF - RegistrationTool - TeleportTool]
- Qboi [Maven Setup]
  
## Community
If you want to be part of our community, join the discord server!
[[Discord Invite Link]](https://discord.gg/rudHdrJ)

## `For Laz:` How to create a release: 
1. Create a GitHub release with a tag in the format `<version>` example: `0.0.1.7`
2. Go to the [JitPack listing](https://jitpack.io/#MultiTeamDevGroup/MultiCore-Lib).
3. Go to the `Releases` tab.
4. Click the `get it` button besides the version. This will make JitPack build the project, and create a maven entry for that version.

**ℹ️ Note:** *this also works with specific commits, but that wouldn't match the released version. However this can be used to test if the features in the lib works.*

## How to add the MultiCore Lib Mod as dependency to your mod.
1. Add the code below to the `build.gradle` in the repositories of the mod that uses the library:  
   ```gradle
   maven {
       url "https://jitpack.io/"
   }
   ```
2. Then add the dependency: *Replace `<mc_version>` with the minecraft version you're using; Replace `<lib_version>` with the version of the mod you'd like to use* - you can find the versions [[here]](https://github.com/MultiTeamDevGroup/MultiTeam-Maven/tree/main/multiteam/multicorelib/MultiCore-Lib)
   ```gradle
   implementation fg.deobf("'com.github.MultiTeamDevGroup:MultiCore-Lib:<version>")
   ```
3. Synchronize the project. In Intelij IDEA you use the sync button from the gradle menu. Or in `cmd.exe` run `gradlew.bat`. Or if you're using linux: `./gradlew`.
