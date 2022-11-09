import { Button, TextField, Typography } from '@mui/material';
import React, { useRef } from 'react';

function CreatetasksForm(props) {
    const titleRef = useRef();
    const descriptionRef = useRef();
    const dayRef =useRef();
    const monthRef =useRef();
    const yearRef =useRef();
    const memberRef=useRef();

    function createtasksHandler(event) {
        event.preventDefault();
        const title = titleRef.current.value;
        const desc = descriptionRef.current.value;
        const day = dayRef.current.value;
        const month = monthRef.current.value;
        const year = yearRef.current.value;
        const members = memberRef.current.value;
        const status = 0;
        const workspace = {
            title:title,
            desc:desc,
            day:day,
            month:month,
            year:year,
            email:members,
            status:status
        };

        props.createtask(workspace);
    }

    return (
        <section style={{ marginTop: '32px' }}>
            <Typography variant='h2' component='h2'>Create New Task</Typography>
            <form onSubmit={createtasksHandler}>
                <TextField
                    id='Name'
                    placeholder='Name'
                    variant='outlined'
                    required
                    fullWidth
                    margin='dense'
                    inputRef={titleRef} />
                <TextField
                    id='Desc'
                    placeholder='Description'
                    variant='outlined'
                    multiline
                    rows={4}
                    required
                    fullWidth
                    margin='dense'
                    inputRef={descriptionRef} />
                <TextField
                    id='day'
                    placeholder='day'
                    variant='outlined'
                    required
                    fullWidth
                    margin='dense'
                    inputRef={dayRef} />
                <TextField
                    id='month'
                    placeholder='month'
                    variant='outlined'
                    required
                    fullWidth
                    margin='dense'
                    inputRef={monthRef} />
                <TextField
                    id='year'
                    placeholder='year'
                    variant='outlined'
                    required
                    fullWidth
                    margin='dense'
                    inputRef={yearRef} />
                <TextField
                    id='member'
                    type={"email"}
                    placeholder='member email'
                    variant='outlined'
                    required
                    fullWidth
                    margin='dense'
                    inputRef={memberRef} />

                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                    Create Task
                </Button>
            </form>
        </section>
    );
}

export default CreatetasksForm;