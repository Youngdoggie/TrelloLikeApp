import React from 'react';
import { Grid, Card, CardContent, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';

function ViewSpaces(props) {
    return (
        <section class="text-center margin5">
            <Typography variant='h2' component='h2'>Workspaces</Typography>
            <Grid container spacing={2}>
                {props.spaces.map((space) => {
                    return (
                        <Grid item xs={12} sm={12} md={4} lg={4} key={space.id}>
                            <Card elevation={6}>
                                <CardContent>
                                    <Typography component='h4' variant='h4'>
                                        {space.title}
                                    </Typography>
                                    <Typography component='p' variant='p'>
                                        {space.description}
                                    </Typography>
                                    <Button variant='outlined' sx={{ marginTop: '16px' }}>
                                        <Link to ={{
                                            pathname: "/board", 
                                            state: { data: space.id } 
                                        }}>
                                        View All Boards
                                        </Link>
                                    </Button>
                                    <Button variant='outlined' sx={{ marginTop: '16px' }}>
                                        <Link to ={{
                                            pathname: "/editworkspace", 
                                            state: { data: space.id } 
                                        }}>
                                        EditWorkspace
                                        </Link>
                                    </Button>
                                    <Button variant='outlined' sx={{ marginTop: '16px' }}>
                                        <Link to ={{
                                            pathname: "/invite", 
                                            state: { data: space.id } 
                                        }}>
                                        Invite Member To this Workspace
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

export default ViewSpaces;
