
# What is LR2oraja?
The latest build of beatoraja, but compiled using LR2 judges and gauges.

### Download Link?
Downloads are on the [Releases](https://github.com/wcko87/lr2oraja/releases) page.

### Using LR2oraja
1. Download the original beatoraja
2. Download LR2oraja from the releases page. LR2oraja's download contains only a single file, **beatoraja.jar**.
3. Replace the **beatoraja.jar** in your original beatoraja with LR2oraja's **beatoraja.jar**.

For help on setting up beatoraja, refer to the [beatoraja English Guide](https://github.com/wcko87/beatoraja-english-guide/wiki)

## Frequently Asked Questions
### Why do this?
Because people wanted it.

### Does this work with beatoraja's IRs or LR2IR?
LR2oraja is not intended to work with IRs.

### Where is the source code?
Switch to the lr2oraja branch in this repository. It's there.

## Changes from the original beatoraja
#### 1. All keymodes (7K, 5K, 10K, 14K, 9K, 24K, 48K etc) will use LR2's gauges by default.
  - You can also see this in practice mode. Practice mode will also have LR2's gauges selected by default.
  - Scratches now have the same timing windows as regular notes.
  - ASSIST EASY / EX-HARD uses vanilla beatoraja's implementations of "LR2 ASSIST EASY" / "LR2 EX-HARD".
    - More specific details: ASSIST EASY is LR2's EASY but with 60% to clear. EX-HARD is LR2's HARD gauge but with double the damage for POORs and BADs (E.POORS are unaffected).

#### 2. HARD / EXHARD Gauge damage and death properties have been changed to match LR2. (for LR2oraja 0.8.3 onwards)
  - In LR2oraja/LR2, HARD gauge damage reduction starts when you have strictly below 32% gauge remaining (not 30%).
  - In LR2oraja/LR2, you fail on HARD gauge if your gauge goes below 2% (not when it hits 0%).
  
#### 3. EASY, NORMAL, HARD and VERYHARD judge timings have been replaced with LR2's judge timings.
  - **Technical details:** If you use practice mode, you might observe that EASY, NORMAL, HARD and VERYHARD judge still use 100%, 75%, 50% and 25% judge windows. Unlike vanilla beatoraja where the judge windows are scaled linearly (proportionally), LR2oraja's judge windows now interpolate between LR2's EASY, NORMAL, HARD and VERYHARD judges. For example, setting judge windows to 70% in LR2oraja's practice mode will put you somewhere in between LR2's NORMAL and HARD judge windows (more precisely, 4/5\*NORMAL + 1/5\*HARD). Image reference: https://imgur.com/a/mnZHgZp
  - **More technical details:** Practice mode's judge window scaling is *different* from EXPAND JUDGE's judge window scaling. EXPAND JUDGE still scales the judge windows linearly like in vanilla beatoraja.
  - VERYEASY judge in LR2oraja is set to 75%, the same as NORMAL judge. It appears that LR2 treats VERYEASY judge as NORMAL judge.

#### 4. LN mechanics are adjusted to fit LR2's LN mechanics. (for LR2oraja 0.8.3 onwards)
- In LR2oraja/LR2, prematurely releasing a LN gives you a BAD. In beatoraja, this gives you a POOR.
- The LN early release tolerance for LR2oraja/LR2 is equal to the GOOD window of a standard note.
  - Assuming that you hit the start of the LN with a PGREAT judgement, releasing anywhere within the GOOD window or later will give you a PGREAT judgement. Releasing before that will give you a BAD judgement.
  - This is different from beatoraja, where the LN release window is also split into GOOD, GREAT and PGREAT judgements, and the final judgement you get on the LN is the worse of the two judgements (press and release). Note: this is for LN mode.
  
#### 5. Window title now states "LR2oraja" instead of beatoraja. Screenshots taken using F6 also include "LR2oraja" in the title.
  - This would hopefully make it easier to tell apart LR2oraja scoreposts from vanilla beatoraja scoreposts.

#### 6. Revised TOTAL calculation for charts without a specified TOTAL value.
  - The default TOTAL calculation formula has been changed to match that of LR2.
    - TOTAL formula used by LR2oraja (0.8.3+): `160 + (N + clamp(N-400, 0, 200))*0.16`, where `N := totalnotes` and `clamp(X,a,b) := min(max(X,a),b)`.
    - beatoraja vs LR2 TOTAL calculation: https://imgur.com/a/X9PnxsP
    

### TODOs / Things that need to be investigated
- None

### LR2 differences I probably won't replicate in LR2oraja
- Differences in LR2's and beatoraja's handling of S-RANDOM with notes that are extremely close to each other.
- Differences in speed change mechanics
- Treatment of #DEFEXRANK in LR2/LR2oraja. Some charts include the #DEFEXRANK parameter, which overrides the judgerank of the chart. This is built into beatoraja's engine.
=======
# beatoraja
Codename beatoraja is a Cross-platform rhythm game based on Java and libGDX.
It works on Windows, Mac OS, and Linux.

# Features
- 3 types of Long Note mode : Long Notes, Charge Notes, Hell Charge Notes, and Back Spin Scratch like iidx
- show note timing duration (like iidx green number), judge details (fast/slow or +-ms)
- 8 types of groove gauge (ex. assist-easy, ex-hard, ex-grade)
- 11 types of clear lamp (ex. assist, light-assist, ex-hard, perfect, and max)
- real-time play speed controller (x0.25 - x4.0. auto play mode, replay mode only)
- various assist options : legacy note, expand judge, bpm guide, and no mine
- pms judge (max 1 miss / 1 notes, combo is reset when miss)
- support bmson 0.2.1, 1.0.0
- practice mode
- import difficulty table folder, create course with various constraint (mirror/random OK, no hispeed, and so on)
- import LunaticRave2 skin (now working in progress. not supporting DirectXArchive(.dxa) and DirectDrawSurface(.dds) file)
- import LunaticRave2 scores (clear lamp, score. not including score verifier like scorehash)

# System Requirement
- Java Runtime Environment 1.8.0 64bit (32bit is not recommended)
- OpenGL 3.1- (may not work under Windows 10 + Intel HD Graphics 2000/3000. See also https://github.com/LWJGL/lwjgl/issues/119)

# How To Use

> java -jar beatoraja.jar -(a|p|r1|r2|r3|r4|s) [BMS path]

- options
  - a : autoplay
  - p : practice
  - r1-r4 : start replay data 1-4
  - s : skip configuration

beatoraja uses a large amount of heap memory. So it is recommended that you use options of extending heap memory : e.g. -Xms1g -Xmx4g.

On JRE 32bit, maximum heap memory size is limited to 1.4G-1.6G. See http://www.oracle.com/technetwork/java/hotspotfaq-138619.html#gc_heap_32bit

**Don't use this application for playing copyrighted contents.**

# License
- GNU General Public License v3

