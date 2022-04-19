const ProductController = require('../controllers/products.controller');
module.exports = function(app){
    app.get('/api', ProductController.index);
    app.post('/api/product', ProductController.createProduct);
}