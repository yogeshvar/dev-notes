---
layout: post
title: "Cache issue with Telegram on macOS"
date: 2020-05-23
categories: git
---

If you don’t know what’s the real issue, please check out the below link,

[**Telegram on Mac OS takes no care about your disk storage and feels great about it.**](https://medium.com/@eugene_lazarev/telegram-on-mac-os-takes-no-care-about-your-disk-storage-and-feels-great-about-it-2c62ded92924)

![](https://miro.medium.com/max/1400/1*ime7T0UUOTy2Bvuv5TyTOA.png)

I have made a few modifications to the bash-script created by [https://medium.com/@eugene_lazarev](https://medium.com/@eugene_lazarev) because _I’m lazy_ enough to run this bash script.

So, I have automated the cache clearing with the help of Automator and LaunchDaemons.

Why Automator? **_LaunchDaemons will not run if your mac is off._**

## `clear_telegram_cache.sh`

Here is the updated script looks like:

```
#!/bin/bash
set -etelegramfolder=$(find ~/Library/Group\\ Containers -type d -maxdepth 1 -name "\*.keepcoder.Telegram")
telegramaccountfolder=$(find "${telegramfolder}" -type d -maxdepth 1 -name "account-\*")if \[ -d "${telegramaccountfolder}" \]; then
 echo "No such file or directory"
else
 rm -r "${telegramaccountfolder}/postbox/media"
 echo "Deleted telegram cache"
fi
```

# Automate using LaunchDaemons

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple Computer//DTD PLIST 1.0//EN" "[http://www.apple.com/DTDs/PropertyList-1.0.dtd](http://www.apple.com/DTDs/PropertyList-1.0.dtd)">
<plist version="1.0">
<dict>
 <key>Label</key>
   <string>com.zerowidth.launched.clear\_telegram</string>
   <key>ProgramArguments</key>
      <array>
       <string>sh</string>
       <string>-c</string>
        <!-- Update your script path here -->
  <!-- NOTE: $HOME/script.sh did not work -->
        <string>/Users/mags/clear\_telegram.sh</string>
   </array>
 <key>RunAtLoad</key>
 <true/>
 <key>StartCalendarInterval</key>
 <dict>
      <!-- Runs at 9.30 everyday -->
      <key>Hour</key>
      <integer>9</integer>
      <key>Minute</key>
      <integer>30</integer>
     </dict>
</dict>
</plist>
```

## Installation:

```
mkdir -p ~/Library/LaunchAgentscurl [https://gist.githubusercontent.com/yogeshvar/2910712810dadcb709c3517f4b228390/raw/93bd3b8bc241b5f848abe49a5b893e0a6819d9f4/clear\_telegram\_cache.plist](https://gist.githubusercontent.com/yogeshvar/2910712810dadcb709c3517f4b228390/raw/93bd3b8bc241b5f848abe49a5b893e0a6819d9f4/clear_telegram_cache.plist) > ~/Library/LaunchAgents/clear\_telegram.plistlaunchctl load -w ~/Library/LaunchAgents/clear\_telegram.plist
```

# Automate using Automator

1.  Open `Automator` application -> select `Application` -> Click `Choose`

![](https://miro.medium.com/max/1400/1*h0nIetQpMHxJxYRCoQj9Ig.png)

2\. Select `run shell script` -> copy & paste `clear_telegram_cache.sh` -> Click `test run`

![](https://miro.medium.com/max/1400/1*M64yA75EVnNzJI3PBesdQA.png)![](https://miro.medium.com/max/1400/1*_L0MHq2Y1_QH_tKEw6krqA.png)

3\. Provide a name for the `application`

![](https://miro.medium.com/max/1400/1*OCFOVUqYGuy8Jeb__JSqeQ.png)

4\. Open `System Preferences` -> Search for `Login Items` -> Add your application

![](https://miro.medium.com/max/1400/1*PgQxzkAKtHe9E8yv9lYgJw.png)![](https://miro.medium.com/max/1400/1*wK_etuT8zz3RBkmQUkya7A.png)

Please let me know if this helps, a huge thanks to [https://medium.com/@eugene_lazarev](https://medium.com/@eugene_lazarev) for the bash-script.

You can also find the gist in [here](https://gist.github.com/yogeshvar/2910712810dadcb709c3517f4b228390)

Thanks for reading 👋 Happy Coding 👨‍💻
