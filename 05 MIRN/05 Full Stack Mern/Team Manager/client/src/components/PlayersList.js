import React from 'react'
import {
    Link
  } from "react-router-dom";
import DeleteButton from './DeleteButton';
import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
const PlayersList = (props) => {
    const { removeFromDom } = props;
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

    return (
        <div>
            <h2>All Players:</h2>
            <Link  to={"/players/addplayer"}>New Player</Link>
        <TableContainer component={Paper}>
      <Table sx={{ maxWidth: 800, margin:"20px auto" }} aria-label="customized table">
        <TableHead>
          <TableRow>
            <StyledTableCell align="center">Name</StyledTableCell>
            <StyledTableCell align="center">Position</StyledTableCell>
            <StyledTableCell align="center">Action</StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
        {props.player.map( (player, i) =>
            <StyledTableRow key={i}>
              <StyledTableCell align="center"><Link  to={"/player/"+player._id}>{player.name}  </Link></StyledTableCell>
              <StyledTableCell align="center">{player.position} </StyledTableCell>
              <StyledTableCell align="center"><DeleteButton playerName={player.name} playerId={player._id} successCallback={()=>removeFromDom(player._id)}/></StyledTableCell>
            </StyledTableRow>
            )}
        </TableBody>
      </Table>
    </TableContainer>
        </div>
    )
}
    
export default PlayersList;