import React from 'react';
import { useHistory } from 'react-router-dom';
import CreateBoardForm from '../Board Components/CreateBoardForm';
import { useLocation } from 'react-router-dom';

function CreateBoardPage() {

    const history = useHistory();
    let spaceIdVal = localStorage.getItem("workspaceID");

    function createBoardHandler(board) {
        fetch(`http://localhost:8080/workspace/addBoard/${spaceIdVal}`, {
            method: 'POST',
            body: JSON.stringify(board),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => response.json())
        .then(()=> history.replace('/workspace'));
    }

    return (
        <CreateBoardForm createBoard={createBoardHandler} />
    );
};

export default CreateBoardPage;