import React from 'react';
import { useHistory } from 'react-router-dom';
import CreateworkspaceForm from '../Workspace Components/CreateworkspaceForm';
import { useEffect, useState } from "react";
function CreateworkspacePage() {

    const history = useHistory();

    function createworkspaceHandler(workspace) {
        fetch('http://localhost:8080/workspace/create',{
            method: 'POST',
            body: JSON.stringify(workspace),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => response.json())
        .then(()=> history.replace('/workspace'));
    }

    return (
        <CreateworkspaceForm createworkspace={createworkspaceHandler} />
    );
};

export default CreateworkspacePage;