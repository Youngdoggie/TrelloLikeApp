import { Button, TextField, Typography } from '@mui/material';
import React, { useRef } from 'react';

function CreateworkspaceForm(props) {
    const titleRef = useRef();
    const descriptionRef = useRef();
    let userIdVal = localStorage.getItem("userID");

    function createworkspaceHandler(event) {
        event.preventDefault();
        const title = titleRef.current.value;
        const description = descriptionRef.current.value;

        const workspace = {title, description, userIdVal};

        props.createworkspace(workspace);
    };

    return (
        <section style={{ marginTop: '32px' }}>
            <Typography variant='h2' component='h2'>Create New WorkSpace</Typography>
            <form onSubmit={createworkspaceHandler}>
                <TextField
                    id='spaceName'
                    placeholder='Name'
                    variant='outlined'
                    required
                    fullWidth
                    margin='dense'
                    inputRef={titleRef} />
                <TextField
                    id='spaceDesp'
                    placeholder='Description'
                    variant='outlined'
                    multiline
                    rows={4}
                    required
                    fullWidth
                    margin='dense'
                    inputRef={descriptionRef} />

                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                    Create Workspace
                </Button>
            </form>
        </section>
    );
}

export default CreateworkspaceForm;