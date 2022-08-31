const Discord = require("discord.js");
const config = require("./config.json");

const client = new Discord.Client();

client.login(config.BOT_TOKEN);

client.on("ready", readyDiscord);

client.on("message", gotMessage);

const replies = [
  "Ouch, sorry my boss went to sleep. I know it's rude he didn't tell you, trust me he is a good man",
  'This is an automated message from Yogi. "Hey Baby, I feel asleep but I love you and have a good night',
  "Yogi is sleeping, please text back once he's back",
  "Hola, I'm afraid to wake up yogi now, if it's really urgent. Please call him.",
  "Message from Yogi: Good night beautiful, Sorry I fell asleep",
  'Yogi fell asleep, but he has got a message for you. "I fell asleep, but I\'m still thinking about you in my sleep. Good night princess" ',
];

function gotMessage(message) {
  if (message.channel.type == "text" && !message.author.bot) {
    message.channel.messages
      .fetch({ limit: 15 })
      .then((messages) => {
        const lastMessagesByMe = messages.filter(
          (msg) => msg.author.id == 586590745947799563
        );

        const lastMessageByMe = Array.from(lastMessagesByMe.values()).pop();

        console.log("Last Msg: ", lastMessageByMe.content);

        if (lastMessageByMe.author.id == 586590745947799563) {
          const minsDiff = timeDiffCalc(
            Date.now(),
            lastMessageByMe.createdTimestamp
          );
          if (minsDiff > 30) {
            if (checkMidNight()) {
              console.log(
                "Mags Sleeping time; Current Hour: ",
                new Date().getHours()
              );
              const index = Math.floor(Math.random() * replies.length);
              console.log(index);
              lastMessageByMe.channel.send(replies[index]);
            } else {
              console.log(
                "Not Mags Sleeping time; Current Hour: ",
                new Date().getHours()
              );
            }
          } else {
            console.log("Mins diff is less than 30", minsDiff);
          }
        }
      })
      .catch((err) => {
        console.log(err);
      });
  }
}

function checkMidNight() {
  const now = new Date().getHours();

  if (now >= 9 && now <= 24) {
    console.log("its day");
    return false;
  } else {
    return true;
  }
}

function readyDiscord() {
  console.log("Discord is ready");
}

function timeDiffCalc(now, lastMsgTime) {
  const diff = now - lastMsgTime;
  const minutes = Math.round(diff / 60000);
  return minutes;
}
