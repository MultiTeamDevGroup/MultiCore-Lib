
![Arcadia Logo](https://raw.githubusercontent.com/MultiTeamDevGroup/MultiCore-Lib/main/src/main/resources/multicore_lib_logo.png)
### for Forge 1.16.5 - by MultiTeam

## About
MultiCoreLib is a library mod for several tools and utils, used by most multiteam mods.

## Credits
- LazTheArtist [TeleportTool - HoverTextItemTool]
- Qboi [Maven Setup]


## Community

If you want to be part of our community, join the discord server!
[[Discord Invite Link]](https://discord.gg/rudHdrJ)

## How to publish to a local maven: ()
:warning:**Note:** *This doesn't upload to web.*:warning:  
**Note:** *You need to push the changes of the maven repo to github*
1. Run  `gradlew build jar uploadArchives`  

## How to add the MultiCore Lib Mod as dependency to your mod.
1. Add the code below to the `build.gradle` in the repositories of the mod that uses the library:  
```gradle
maven {
    url "https://github.com/MultiTeamDevGroup/MultiTeam-Maven/raw/main/"
}
```
2. Then add the dependency: *Replace `<version>` with the mod's version*
```gradle
compile fg.deobf("multiteam.multicorelib:multicore_lib:<version>")
```
3. Synchronize the project. In Intelij IDEA you use the sync button from the gradle menu. Or in `cmd.exe` run `gradlew.bat`. Or if you're using linux: `./gradlew`.
