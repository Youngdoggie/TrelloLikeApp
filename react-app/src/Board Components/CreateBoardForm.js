import { Button, TextField, Typography } from '@mui/material';
import React, { useRef } from 'react';

function CreateBoardForm(props) {
    const boardNameRef = useRef();

    function createBoard(e) {
        e.preventDefault();
        const boardName = boardNameRef.current.value;

        const board = {
            title: boardName
        };

        props.createBoard(board);
    };

    return (
        <section style={{ marginTop: '32px' }}>
            <Typography variant='h2' component='h2'>Create New Board</Typography>
            <form onSubmit={createBoard}>
                <TextField
                    id='boardName'
                    placeholder='Board Title'
                    variant='outlined'
                    required
                    fullWidth
                    margin='dense'
                    inputRef={boardNameRef} />
                <Button type='submit' variant='contained' color='primary' sx={{ marginTop: '16px' }}>
                    Create Board
                </Button>
            </form>
        </section>
    );
};

export default CreateBoardForm;