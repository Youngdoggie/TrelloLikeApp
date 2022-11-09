import React, { useRef } from 'react';
import { Grid, Card, CardContent, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';
import { useLocation } from 'react-router-dom';
import {useHistory} from "react-router-dom";
import SearchPage from '../Task/Search';

function Viewtasks(props) {
    const searchRef = useRef();

    function SearchKeyWordHandler(event){
        event.preventDefault();
        const keyWord = searchRef.current.value;

        SearchPage(keyWord);
    }
    
    return (
        <section style={{ marginTop: '32px' }}>
            <Typography variant='h2' component='h2'>Tasks</Typography>
            <Button variant='outlined' sx={{ marginTop: '16px' }}>
                <Link to ={{
                    pathname: "/createTasks",
                }}>
                    Create Task
                </Link>
            </Button>

            <form on onSubmit={SearchKeyWordHandler}>
                <input type = {"text"} required placeholder='search' ref = {searchRef}/>
                <button>Search</button>
            </form>

            <p>  </p>
            <Button variant='outlined' sx={{ marginTop: '16px' }}>
                <Link to ={{pathname: "/dueInWeek",}}>
                    View due in a week
                </Link>
            </Button>
            <Button variant='outlined' sx={{ marginTop: '16px' }}>
                <Link to ={{pathname: "/dueToday",}}>
                    View due today
                </Link>
            </Button>
            <Button variant='outlined' sx={{ marginTop: '16px' }}>
                <Link to ={{pathname: "/overDue",}}>
                    view overDue
                </Link>
            </Button>
            <p>   </p>
            <Grid container spacing={2}>
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
            </Grid>
        </section>
    );
};

export default Viewtasks;
