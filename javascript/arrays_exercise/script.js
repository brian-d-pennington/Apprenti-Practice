// scripts tested with Node command: node script.js

// Declaring and Accessing Arrays

// 1. Create an array called fruits
const fruits = ["apple", "banana", "cherry", "date"];

// 2. Print the entire array to the console
console.log(fruits);

// 3. Print the first and last elements using their index positions
console.log("First element:", fruits[0]);
console.log("Last element:", fruits[fruits.length - 1]);

// Modifying Arrays

// 1. Replace "banana" with "blueberry"
fruits[1] = "blueberry";
// Alternative: fruits[fruits.indexOf("banana")] = "blueberry";

// 2. Add "elderberry" to the end of the array
fruits.push("elderberry");

// 3. Add "apricot" to the beginning of the array
fruits.unshift("apricot");

// 4. Remove the first element and print it
const removedFirst = fruits.shift();
console.log("Removed first element:", removedFirst);

// 5. Remove the last element and print it
const removedLast = fruits.pop();
console.log("Removed last element:", removedLast);

// 6. Print the updated array
console.log("Updated array:", fruits);

// Looping Through an Array

// 1. Create a loop that prints each element in the fruits array
console.log("Printing all elements:");

for (let i = 0; i < fruits.length; i++) {
    console.log(fruits[i]);
}

console.log("\n"); // Empty line for separation

// 2. Modify the loop so that it skips every other element
console.log("Printing every other element:");

for (let i = 0; i < fruits.length; i += 2) {
    console.log(fruits[i]);
}

// Advanced Array Methods

// 1. Use .indexOf() to find the index of "cherry" and print the result
const cherryIndex = fruits.indexOf("cherry");
console.log("Index of 'cherry':", cherryIndex);

// 2. Use .splice() to remove "cherry" from the array
fruits.splice(cherryIndex, 1);
console.log("Array after removing 'cherry':", fruits);

// 3. Use .concat() to add another array to fruits
// must declare new array as fruits is a CONST
const newFruits = ["fig", "grape", "honeydew"];
const combinedFruits = fruits.concat(newFruits);

// 4. Print the final array
console.log("Final array:", combinedFruits);
