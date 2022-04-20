import React from 'react'
import axios from 'axios';
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
import Button from '@mui/material/Button';
const AuthorList = (props) => {
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
            <h2>All Authors:</h2>
            <Link  to={"/author/new"}>New Author</Link>
        <TableContainer component={Paper}>
      <Table sx={{ maxWidth: 800, margin:"20px auto" }} aria-label="customized table">
        <TableHead>
          <TableRow>
            <StyledTableCell align="center">Name</StyledTableCell>
            <StyledTableCell align="center">Actions</StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
        {props.author.map( (author, i) =>
            <StyledTableRow key={i}>
              <StyledTableCell align="center"><Link  to={"/author/"+author._id}>{author.name}  </Link></StyledTableCell>
              <StyledTableCell align="center"><Button size="large"><Link  to={"/author/"+author._id+"/edit"}>Edit</Link></Button> <DeleteButton authorId={author._id} successCallback={()=>removeFromDom(author._id)}/></StyledTableCell>
            </StyledTableRow>
            )}

        </TableBody>
      </Table>
    </TableContainer>
        </div>
    )
}
    
export default AuthorList;