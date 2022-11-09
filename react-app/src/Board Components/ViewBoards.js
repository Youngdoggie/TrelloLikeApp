import React from 'react';
import { Grid, Card, CardContent, Typography, Button } from '@mui/material';
import {Link} from "react-router-dom";
import { useLocation } from 'react-router-dom';
import {useHistory} from "react-router-dom";


function ViewBoards(props) {
        const history = useHistory();
        let workspaceID = localStorage.getItem("workspaceID");
        
        function DeleteHandler(ID) {    
            fetch(`http://localhost:8080/workspace/${workspaceID}/${ID}`,{
                method: 'DELETE',
            }).then(()=> history.replace('/workspace'));    
        }

        return (
            <section style={{ marginTop: '32px' }}>
                <Typography variant='h2' component='h2'>Boards</Typography>
                <Button variant='outlined' sx={{ marginTop: '16px' }}>
                    <Link to ={{
                        pathname: "/createboard", 
                    }}>
                        Create Board
                    </Link>
                </Button>

                <p>   </p>

                <Grid container spacing={2}>
                    {props.boards.map((boards) => {
                        return (
                            <Grid item xs={12} sm={12} md={4} lg={4} key={boards.id}>
                                <Card elevation={6}>
                                    <CardContent>
                                        <Typography component='h4' variant='h4'>
                                            {boards.title}
                                        </Typography>
                                        <Button variant='outlined' onClick={()=> DeleteHandler(boards.id)} sx={{ marginTop: '16px' }}>
                                            Delete Board
                                        </Button>
                                        <Button variant='outlined' sx={{ marginTop: '16px' }}>
                                           <Link to ={{
                                            pathname: "/tasks", 
                                            state:{getTasksData : boards.id}}}>
                                               View My Tasks
                                            </Link>
                                        </Button>
                                    </CardContent>
                                </Card>
                            </Grid>
                        );
                    })}
                </Grid>
            </section>
        );
};

export default ViewBoards;