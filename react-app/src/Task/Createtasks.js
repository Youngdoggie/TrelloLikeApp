import React from 'react';
import { useHistory } from 'react-router-dom';
import CreatetasksForm from "../Task Components/CreatetasksForm";
import { useEffect, useState } from "react";
function CreateTaskPage() {

    const history = useHistory();
    let boardIdVal = localStorage.getItem("BoardID");

    function CreateTaskHandler(task) {
        fetch(`http://localhost:8080/board/${boardIdVal}`,{
            method: 'POST',
            body: JSON.stringify(task),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => response.json())
            .then(()=> history.replace('/workspace'));
    }

    return (
        <CreatetasksForm createtask={CreateTaskHandler} />
    );
};

export default CreateTaskPage;