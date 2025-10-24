// Function basics

function greetUser(name) {
    console.log("Hello " + name);
}

greetUser("Brian");
greetUser("Ant");

// Returning Values

function squareNumber(num) {
    return num * num;
}

let fourSquared = squareNumber(4);
let sevenSquared = squareNumber(7);

console.log(fourSquared + " " + sevenSquared);

//  Multiple Parameters
function addNumbers(num1, num2) {
    return num1 + num2;
}

console.log(addNumbers(10, 5));
console.log(addNumbers(3, 8));

// Random Color Generator

let colors = ["red", "blue", "green", "yellow", "purple", "orange"];

function getRandomColor() {
    const randomIndex = Math.floor(Math.random() * colors.length);
    return colors[randomIndex];
}

console.log(getRandomColor());
console.log(getRandomColor());
console.log(getRandomColor());

// Random Fortune Teller

let fortunes = [
    "You will have a great day!",
    "A surprise is waiting for you.",
    "Something exciting is coming soon.",
    "Be cautious with your decisions today.",
    "Happiness is around the corner."
];

function tellFortune() {
    const randomIndex = Math.floor(Math.random() * fortunes.length);
    return fortunes[randomIndex];
}

console.log(tellFortune());


// Create a function named getRandomColor that returns a random color from this array:
// let colors = ["red", "blue", "green", "yellow", "purple", "orange"];