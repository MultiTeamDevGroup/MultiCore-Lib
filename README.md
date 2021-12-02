
![MultiCoreLib Logo](https://raw.githubusercontent.com/MultiTeamDevGroup/MultiCore-Lib/main/src/main/resources/multicore_lib_logo.png)
### for Forge 1.18 - by MultiTeam

## About
MultiCoreLib is a library mod for several tools and utils, used by most multiteam mods.

## Credits
- LazTheArtist [HoverTextItemTool - ItemGroupTool - ItemManagementTool - MathF - RegistrationTool - TeleportTool]
- Qboi [Maven Setup]
  
## Community
If you want to be part of our community, join the discord server!
[[Discord Invite Link]](https://discord.gg/rudHdrJ)

## How to publish to a local maven:
:warning:**Note:** *This doesn't upload to web.*:warning:  
**Note:** *You need to push the changes of the maven repo to github*
1. Run  `gradlew build publish`  

## How to add the MultiCore Lib Mod as dependency to your mod.
1. Add the code below to the `build.gradle` in the repositories of the mod that uses the library:  
```gradle
maven {
    url "https://github.com/MultiTeamDevGroup/MultiTeam-Maven/raw/main/"
}
```
2. Then add the dependency: *Replace `<mc_version>` with the minecraft version you're using; Replace `<lib_version>` with the version of the mod you'd like to use* - you can find the versions [[here]](https://github.com/MultiTeamDevGroup/MultiTeam-Maven/tree/main/multiteam/multicorelib/MultiCore-Lib)
```gradle
runtimeOnly fg.deobf("multiteam.multicorelib:MultiCore-Lib:<mc_version>-<lib_version>")
compileOnly fg.deobf("multiteam.multicorelib:MultiCore-Lib:<mc_version>-<lib_version>")
```
3. Synchronize the project. In Intelij IDEA you use the sync button from the gradle menu. Or in `cmd.exe` run `gradlew.bat`. Or if you're using linux: `./gradlew`.
