const book = {
    title: "JavaScript Basics",
    author: {
    name: "John Doe",
    social: {
    twitter: "@johndoe"
    }
    }
   };
   
   // Use optional chaining to access the Twitter handle
   
   console.log(book.author?.social?.twitter); // prints @johndoe
   
   // Try accessing a non-existent property using optional chaining
   
   console.log(book.publisher?.name); // prints undefined

// ○ What happens when you try to access book.publisher?.name?

// It prints undefined

// ○ How does optional chaining prevent errors in this scenario?

// The code still runs even without a defined key

// ○ What would happen if we removed ?. in book.publisher?.name?

// It gets an error message:

// TypeError: Cannot read properties of undefined (reading 'name')
//     at Object.<anonymous> (/Users/brianpennington/Desktop/javaPractice/Apprenti-Practice/javascript/Chaining_exercise/script.js:17:31)
//     at Module._compile (node:internal/modules/cjs/loader:1254:14)
//     at Module._extensions..js (node:internal/modules/cjs/loader:1308:10)
//     at Module.load (node:internal/modules/cjs/loader:1117:32)
//     at Module._load (node:internal/modules/cjs/loader:958:12)
//     at Function.executeUserEntryPoint [as runMain] (node:internal/modules/run_main:81:12)
//     at node:internal/main/run_main_module:23:47

// 1. Object with an *optional* `edition` property
const book2 = {
    title: "JavaScript Basics",
    author: {
      name: "John Doe",
      social: {
        twitter: "@johndoe"
      }
    },
    // Comment-out (or remove) this line to simulate “no edition”
    edition: 2021
  };
  
  /* 2. Check for the property and log accordingly */
  if ('edition' in book2) {
    console.log(`Edition year: ${book2.edition}`);
  } else {
    console.log('Edition information not available.');
  }
