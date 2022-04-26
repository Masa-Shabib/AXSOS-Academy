import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import Button from '@mui/material/Button';
import {
    Link
  } from "react-router-dom";
const PlayerStatus = (props) => {

    const StyledTableCell = styled(TableCell)(({ theme }) => ({
        [`&.${tableCellClasses.head}`]: {
          backgroundColor: theme.palette.common.black,
          color: theme.palette.common.white,
        },
        [`&.${tableCellClasses.body}`]: {
          fontSize: 14,
        },
      }));
      
      const StyledTableRow = styled(TableRow)(({ theme }) => ({
        '&:nth-of-type(odd)': {
          backgroundColor: theme.palette.action.hover,
        },
        // hide last border
        '&:last-child td, &:last-child th': {
          border: 0,
        },
      }));
      const [players, setPlayers] = useState([]);
      
      useEffect(()=>{
          axios.get('http://localhost:8000/api/players/list')
              .then(res=>{
                  setPlayers(res.data);
              })
              .catch(err => console.error(err));
      },[]);
      const handleClick = (player ,status,i) =>{
        let updatedPlayer={}
        updatedPlayer={...player, gameOne:status}
        axios.put('http://localhost:8000/api/players/'+ player._id ,updatedPlayer )
              .then(res=>{
                updatePlayerInDom(status,i)
              })
              .catch(err => console.error(err));
      }
      const updatePlayerInDom = ( status,i) => {
        let playerToChange = players[i];
        playerToChange.gameOne = status;
        const newPlayers = [...players];
        newPlayers[i] = playerToChange;
        setPlayers(newPlayers);
    };

  return (
    <div>
        <h2>Game 1</h2>
        <Link to="/status/game/1" >Game 1</Link>
        <Link to="/status/game/2">Game 2</Link>
        <Link to="/status/game/3">Game 3</Link>
        <TableContainer component={Paper}>
      <Table sx={{ maxWidth: 800, margin:"20px auto" }} aria-label="customized table">
        <TableHead>
          <TableRow>
            <StyledTableCell align="center">Name</StyledTableCell>
            <StyledTableCell align="center">Action</StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
        {players.map( (player, i) =>
            <StyledTableRow key={i}>
              <StyledTableCell align="center">{player.name}</StyledTableCell>
              <StyledTableCell align="center"> 
              <Button variant={player.gameOne === "playing"? "contained" :
                  "outlined"} size="medium" color='success' onClick={e => handleClick(player,"playing",i)}>Playing</Button>
              <Button variant={player.gameOne === "notPlaying"? "contained" :
                  "outlined"} size="medium" color='success' onClick={e => handleClick(player,"notPlaying",i)}>Not Playing</Button>
              <Button variant={player.gameOne === "undecided"? "contained" :
                  "outlined"} size="medium" color='warning' onClick={e => handleClick(player,"undecided",i)}>Undecided</Button>
              </StyledTableCell>
            </StyledTableRow>
            )}
        </TableBody>
      </Table>
    </TableContainer>
        </div>
  )
}

export default PlayerStatus