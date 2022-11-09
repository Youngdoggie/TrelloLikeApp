import React from 'react';
import { useHistory } from 'react-router-dom';
import { useLocation } from 'react-router-dom';

import ChangeStatusForm from "../Task Components/ChangeStatusForm";
function ChangeStatusPage() {

    const history = useHistory();
    const location = useLocation();

    localStorage.setItem("tasksID", location.state.currentTaskID);

    function  ChangeStatusHandler(task) {
        fetch(`http://localhost:8080/task/${location.state.currentTaskID}`,{
            method: 'PUT',
            body: JSON.stringify(task),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => response.json())
            .then(()=> history.replace('/tasks'));
    }

    return (
        <ChangeStatusForm createtask={ChangeStatusHandler} />
    );
}

export default ChangeStatusPage;