import React, { useRef } from 'react';
import { Grid, Card, CardContent, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';
import { useLocation } from 'react-router-dom';
import {useHistory} from "react-router-dom";

function SearchForm(props){
    
    return (
        <section style={{ marginTop: '32px' }}>
            <p>   </p>
                {props.tasks.map((tasks) => {
                    return (
                        <Grid item xs={12} sm={12} md={4} lg={4} key={tasks.status = 0}>
                            <Card elevation={6}>
                                <CardContent>
                                    <Typography component='h4' variant='h4'>
                                        {tasks.name}
                                    </Typography>
                                    <Typography component='p' variant='p'>
                                        {tasks.taskDesc}
                                    </Typography>
                                    <Button variant='outlined' sx={{ marginTop: '16px' }}>
                                           <Link to ={{
                                            pathname: "/changeStatus", 
                                            state:{currentTaskID : tasks.id}}}>
                                               Change Status
                                            </Link>
                                    </Button>
                                    <Button variant='outlined' sx={{ marginTop: '16px' }}>
                                           <Link to ={{
                                            pathname: "/inviteMember", 
                                            state:{inviteTaskID : tasks.id}}}>
                                               Invite Person to Task
                                            </Link>
                                    </Button>
                                </CardContent>
                            </Card>
                        </Grid>
                    );
                })}

        </section>
    );
};

export default SearchForm;