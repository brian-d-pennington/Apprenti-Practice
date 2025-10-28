const book = {
    title: "The Great Gatsby",
    author: "F. Scott Fitzgerald",
    year: 1925,
  };
  
  // 1. Refactor in a single line
  const { title, author, year } = book;
  
  // 2. Log the values
  console.log(title);  // "The Great Gatsby"
  console.log(author); // "F. Scott Fitzgerald"
  console.log(year);   // 1925

  // or
//   console.log(title, author, year);

// Destructure & rename in one step
const { title: bookTitle, author: writer } = book;

// Log the renamed variables
console.log(bookTitle); // "The Great Gatsby"
console.log(writer);    // "F. Scott Fitzgerald"