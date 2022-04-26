const PlayerController = require('../controllers/players.controller');
module.exports = function(app){
    app.get('/api', PlayerController.index);
    app.post('/api/players/addPlayer', PlayerController.createPlayer);
    app.get('/api/players/list', PlayerController.getAllPlayers);
    // app.get('/api/status/game/:id', PlayerController.getplayers);
    app.put('/api/players/:id', PlayerController.updatePlayer);
    app.delete('/api/players/:id', PlayerController.deletePlayer);
}