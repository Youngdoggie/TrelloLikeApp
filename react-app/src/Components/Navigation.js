import { Link} from "react-router-dom";
import React, { useState } from "react"
import {Box, AppBar, Toolbar, Typography, Button} from '@mui/material';

function Navigation(){
    const ConditionalLink = ({ children, to, condition }) => (!!condition && to)
      ? <Link to={to}>{children}</Link>
      : <>{children}</>;

    return(
        <Box sx={{ flexGrow: 1 }}>
            <AppBar position="static" sx={{ bgcolor: "black" }}>
                <Toolbar>
                    <Typography variant="h4" sx={{flexGrow:1}}>
                        <ConditionalLink to='/home' style={{textDecoration: 'none', color:'white'}} condition = {localStorage.getItem("userID") !== null}>
                            Trello
                           </ConditionalLink>
                    </Typography>
                    <Button variant="h6" component="div" sx={{padding: '0 8px'}}>
                        <Link to='/Login' style={{textDecoration: 'none', color:'white'}}>
                            Login
                        </Link>
                    </Button>
                    <Button variant="h6" component="div" sx={{padding: '0 8px'}}>
                        <Link to='/register' style={{textDecoration: 'none', color:'white'}}>
                            Register
                        </Link>
                    </Button>
                </Toolbar>
            </AppBar>
        </Box>
    );
}

export default Navigation;
