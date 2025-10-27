// refactor object using shorthand

const title = "Software Engineer";
const company = "Tech Corp";
const location = "New York";

// Original Object:

// const job = {
//     title: title,
//     company: company,
//     location: location
//    };

const job = { title, company, location };

console.log(job);
// prints { title: 'Software Engineer', company: 'Tech Corp', location: 'New York' }