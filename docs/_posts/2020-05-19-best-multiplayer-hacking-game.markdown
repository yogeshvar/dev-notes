---
layout: post
title: "Best multiplayer hacking game"
date: 2020-05-19
categories: game, multiplayer, hacking
---

_Hacking is the gaining of unauthorised access to data in a system or computer. It’s more fun when things are gamified._

Out of boredom, I have started playing games on steam a lot. Thanks to COVID for bringing out the gamer in me that too in macOS. I started with Dota 2, Counter-Strike, and Overcooked 2. Then I came across a game called GreyHack.

# First Impressions:

- Easily understandable by the name itself, it was a type of tech game that involves gamified hacking experience.
- Costs 459 bucks (I have never spent that much money for a steam macOS game)

Then after my salary day, I bought [GreyHack](https://store.steampowered.com/app/605230/Grey_Hack/). :P

![](https://miro.medium.com/max/920/1*DeT-Cnpd4sa68B6uVHITQw.jpeg)

GreyHack is a massively multiplayer hacking simulator game. You’re a hacker of full freedom to hack any machines in the game. The game allows the user to experience a single-player and multiplayer mode as well. Both the gameplays are more or less the same, but in multiplayer mode, you might have these differences:

- Any player in the game can hack your machine.
- You can chat with other players using the chat
- Buy hacking scripts from other hackers

The game’s interface replicates one of the Linux distributions with a terminal, File explorer, Text Editors, and few more essential applications.

![](https://miro.medium.com/max/1400/1*9ylFAj3Si61aVeFNIHjV8Q.png)GreyHack Desktop

If you start as a new hacker, getting the WiFi password is hard. Sometimes, you can get it from the Gift.txt file. If not, you have to hack the WiFi networks and get the password.

# Cracking WiFi Password

![](https://miro.medium.com/max/1400/1*Ro9bBX0VbyCjmD7wXln3Ag.png)Commands for Cracking WiFi Password

![](https://miro.medium.com/max/1400/1*VVNZooftH4F8gSHyupTByw.png)🎉 You are now connected to the internet. Let’s get some important things to run the show.

# Creating a mail account: (Hackable in Multiplayer Mode)

![](https://miro.medium.com/max/1400/1*kqQVH-NbxuE8DRGGTvKxyw.png)

- Open Browser, then Search for Mail. Then provide a username & password.
- Once you created the mail account. You will receive a mail from someone anonymous person.

# Creating a Bank Account: (Hackable in Multiplayer Mode)

![](https://miro.medium.com/max/1400/1*rXJ-SGfIkSQl_1oMLIeNHA.png)

- Open Browser, then Search for Bank. Then provide your in-game email & password.
- You can earn more money by stealing from other players or Jobs.

# Shops Network:

![](https://miro.medium.com/max/1400/1*_bz3cVoYsGVNwrf-FlXAEQ.png)

- Open Browser, then Search for Shop. You can find tools useful for hacking a machine. Check the description and get it.
- You can also upgrade your hardware with money.

# Hacker Network:

![](https://miro.medium.com/max/1400/1*VhZKTy7uKxFFC2AFO-_kaA.png)

- You can visit the IP Address which you received from the anonymous person.
- You can find Jobs, Tools, and Exploits.

# Let’s do some dirty work:

- Find a job to earn money. In this example, we will try to change academic grades for a client. Once you accept the contract you will get information from the client.

![](https://miro.medium.com/max/1400/1*MnH4rJ9_MZpTA2UdjfUiBg.png)

- Grab `nmap` from the Shops Market, and do `nmap` on the victim.

![](https://miro.medium.com/max/1400/1*2uP8XlCcZVn6qwoqdZ0vJg.png)

- Dang 😎, we found something interesting here. Next, we will try to find exploits in Hacker Network.

![](https://miro.medium.com/max/1400/1*huDIlhl7dsortUziZh97UQ.png)

- Check the description of the exploit and then get it. Here `gine5un5` and `odgescript` both get bank credentials, yet `odgescript` works only if the target machine has any active user whereas `gine5un5` does not have any restriction.

![](https://miro.medium.com/max/1400/1*KS6fbpvNbb_QnCmnB1wkjg.png)

- Using the `browser` ; log in to other Bank Accounts and transfer the money to your account.

![](https://miro.medium.com/max/1400/1*6WImtwwfIBfKTdqrF3SycQ.png)

- We will do for we came from, using a different exploit `chscript` . Gained access for a user named `Nellet`
- Passwords are stored in `etc/passwd` . Copy the content to a text file and decipher the text file to obtain the root password.
- Modify the student’s academic grades after you open up `StudentViewer.exe` and save it.

# Do it neat and clear:

![](https://miro.medium.com/max/1400/1*tlUzViHpCc-YypGhXtUeFg.png)

- Hackers don’t leave any trace behind. We have to make sure that the victim does not suspect anything weird or strange.
- Check the `LogViewer.exe` and delete the logs of your IP. _(If you fail to do this, the victim can hack you back and steal your money, mail account and so on)_

# Contract disclosure:

![](https://miro.medium.com/max/1400/1*Wrt4DUGrVC4kcGfToF0_mQ.png)

- Reply to the mail with “Done”; If the customer is satisfied with the job, check your bank for the reward.

# How to level up?

- Head to Hacker Network. Find a job and accept the contract.
- Get Basic Tools like `nmap` and suitable exploits.
- Do it right and neat.

Leave a comment, if you want to know more about [GreyHack](https://store.steampowered.com/app/605230/Grey_Hack/) tips and hacks.

Thanks for reading 👋 Happy Hacking 👨‍💻
