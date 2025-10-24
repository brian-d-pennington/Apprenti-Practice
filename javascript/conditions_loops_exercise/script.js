// Part 1: If Statements (Even or Odd Checker)

const randomNumber = Math.floor(Math.random() * 50) + 1;

if (randomNumber % 2 === 0) {
  console.log(`${randomNumber} is even.`);
} else {
  console.log(`${randomNumber} is odd.`);
}

// CONSOLE QUESTIONS BELOW FOR BETTER PROMPT EXECTION

// Part 3: While Loop (Rolling a Dice)
  
  let roll;
  
  do {
    roll = Math.floor(Math.random() * 6) + 1;
    console.log(`Rolled: ${roll}`);
  } while (roll !== 6);
  
  console.log("You rolled a 6 — stopping!");

  // Part 2: Switch Statement (Day of the Week)

// ****** Prompt doesn't work on my machine, so running the Node version ReadLine ******

const rl = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
  });
  
  rl.question('Enter a number between 0 and 6: ', answer => {
    const num = parseInt(answer, 10);
    let day;
  
    switch (num) {
      case 0: day = 'Sunday';    break;
      case 1: day = 'Monday';    break;
      case 2: day = 'Tuesday';   break;
      case 3: day = 'Wednesday'; break;
      case 4: day = 'Thursday';  break;
      case 5: day = 'Friday';    break;
      case 6: day = 'Saturday';  break;
      default:
        console.log('Error: number must be between 0 and 6.');
    }
  
    if (day) console.log(`Day ${num} is ${day}.`);
    rl.close();
  });

//   Part 4: For Loop (Counting Down)

// QUESTIONS HAVE TO BE EXECUTED ONE AT A TIME

rl.question("Enter a starting number: ", answer => {
    const start = parseInt(answer, 10);
  
    if (!isNaN(start)) {
      for (let i = start; i >= 0; i--) {
        console.log(i);
      }
    } else {
      console.log("Please enter a valid number.");
    }
    rl.close();
  });