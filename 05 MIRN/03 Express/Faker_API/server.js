// const express = require("express");
// const app = express();
// const port = 8000;
// const { faker } = require('@faker-js/faker');
// // req is shorthand for request
// // res is shorthand for response
// app.get("/api", (req, res) => {
//     res.json({ message: "Hello World!!!!123" });
// });
// const  createUser = () => {
//     const newFake = {
//         password: faker.commerce.productName(),
//         email: '$' + faker.commerce.price(),
//         phoneNumber: faker.commerce.department(),
//         lastName: faker.commerce.department(),
//         firstName: faker.commerce.department(),
//         _id: faker.commerce.department()
//     };
//     return newFake;
// };
// const createProduct = () => {
//     const newFake = {
//         name: faker.commerce.productName(),
//         price: '$' + faker.commerce.price(),
//         department: faker.commerce.department()
//     };
//     return newFake;
// };
    
// app.get("/api/faker", (req, res) => {
//     const newFakeProduct = createProduct();
//         res.json(newFakeProduct);
//     });
// app.listen( port, () => console.log(`Listening on port: ${port}`) );
const express = require("express");
const app = express();
const port = 8000;
const { faker } = require('@faker-js/faker');

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

const createUser = () => {
    const newUser = {
        password: faker.internet.password(),
        email: faker.internet.email(),
        phoneNumber: faker.phone.phoneNumber(),
        lastName: faker.name.lastName(),
        firstName: faker.name.firstName(),
        id: faker.datatype.number()
    };
    return newUser;
};

const createCompany = () => {
    const newUser = {
        id: faker.datatype.number(),
        name: faker.company.companyName(),
        address:{
            street: faker.address.streetName(),
            city: faker.address.cityName(),
            state: faker.address.state(),
            zipCode: faker.address.zipCode(),
            country: faker.address.country(),
        }
    };
    return newUser;
};
const createProduct = () => {
         const newFake = {
             name: faker.commerce.productName(),
             price: '$' + faker.commerce.price(),
             department: faker.commerce.department()
         };
         return newFake;
     };
        
     app.get("/api/faker", (req, res) => {
         const newFakeProduct = createProduct();
             res.json(newFakeProduct);
         });
app.get("/api/users/new", (req, res) => {
    const newUser = createUser();
    res.json(newUser);
});

app.get("/api/companies/new", (req, res) => {
    const newCompany = createCompany();
    res.json(newCompany);
});

app.get("/api/user/company", (req, res) => {
    const newUser = createUser();
    const newCompany = createCompany();
    res.json([newUser, newCompany]);
});

const server = app.listen(8000, () =>
    console.log(port, () => console.log(`Listening on port: ${port}`))
);