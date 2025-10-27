// Create a Car object
const car = {
    make: "Toyota",
    model: "Corolla",
    year: 2021,
    color: "red",
    drive: function() {
      console.log("The car is driving.");
    }
  };
  
  // Call the drive() function
  car.drive();

  // Change the color to "blue"
car.color = "blue";

// Add a new property fuelType
car.fuelType = "gasoline";

// Delete the year property
// delete car.year;

console.log("Modified car:", car);

// Driver object
const driver = {
    name: "John",
    licenseNumber: "ABC123456",
    age: 30
  };
  
  // Add Driver to Car
  car.driver = driver;
  
  console.log("Complete Car object:");
  console.log(car);
  
  console.log("\nDriver's name:", car.driver.name);
  console.log("Driver's license:", car.driver.licenseNumber);
  console.log("Driver's age:", car.driver.age);

// Convert the Car object to JSON

var printCar = JSON.stringify(car);
console.log("Stringify car object: " + printCar);

// Parse stringified JSON back into object

var carObject = JSON.parse(printCar);
console.log("Car object: " + carObject);

// Access properties
console.log("\nAccessing properties:");
console.log("Make:", carObject.make);
console.log("Model:", carObject.model);
console.log("Year:", carObject.year);
console.log("Color:", carObject.color);
console.log("Fuel Type:", carObject.fuelType);
console.log("Driver's Name:", carObject.driver.name);
console.log("Driver's License:", carObject.driver.licenseNumber);
console.log("Driver's Age:", carObject.driver.age);