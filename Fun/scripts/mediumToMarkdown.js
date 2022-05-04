const mediumToMarkdown = require('medium-to-markdown');

// Enter url here
mediumToMarkdown.convertFromUrl('https://medium.com/macoclock/cache-issues-with-telegram-on-mac-os-f293fdbe7687')
    .then(function (markdown) {
        console.log(markdown); //=> Markdown content of medium post
    });