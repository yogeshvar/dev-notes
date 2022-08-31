var text = "THIS IS A TEST TEXT";
var pattern = "TEST";

for (let t = 0; t < text.length - pattern.length; t++) {
  let j;
  for (j = 0; j < pattern.length; j++) {
    if (text[t + j] != pattern[j]) {
      break;
    }
  }
  if (j == pattern.length) console.log(t);
}
