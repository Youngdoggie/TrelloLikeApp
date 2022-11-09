import React, { useRef } from 'react';
import { Grid, Card, CardContent, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';
import { useLocation } from 'react-router-dom';
import {useHistory} from "react-router-dom";

function ViewDueToday(props){
    return(
        <section style={{ marginTop: '32px' }}>
            {props.tasks.map((tasks) => {
                    return (
                        <Grid item xs={12} sm={12} md={4} lg={4} key={tasks.id}>
                            <Card elevation={6}>
                                <CardContent>
                                    <Typography component='h4' variant='h4'>
                                        {tasks.name}
                                    </Typography>
                                    <Typography component='p' variant='p'>
                                        {tasks.taskDesc}
                                    </Typography>
                                </CardContent>
                            </Card>
                        </Grid>
                    );
                })
            }
        </section>
    );
}

export default ViewDueToday;