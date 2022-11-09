import React, {useRef} from "react";
import ChangeStatusPage from "../Task/ChangeStatus";
import {InputLabel, NativeSelect, Button} from "@mui/material";
import { useHistory } from 'react-router-dom';

function ChangeStatusForm(props){

    const history = useHistory();
    let taskID = localStorage.getItem("tasksID");
    const DueWeek = {status : 0};
    const Doing = {status : 1};
    const OverDue = {status : 2};

    function ToDoStatusHandler(){
        fetch(`http://localhost:8080/task/${taskID}`,{
            method: 'PUT',
            body: JSON.stringify(DueWeek),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => response.json())
        .then(()=> history.replace('/workspace'));
    }

    function DoingStatusHandler(){
        fetch(`http://localhost:8080/task/${taskID}`,{
            method: 'PUT',
            body: JSON.stringify(Doing),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => response.json())
        .then(()=> history.replace('/workspace'));
    }

    function OverDueStatusHandler(){
        fetch(`http://localhost:8080/task/${taskID}`,{
            method: 'PUT',
            body: JSON.stringify(OverDue),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => response.json())
        .then(()=> history.replace('/workspace'));
    }

    return(
        <section style={{ marginTop: '32px' }}>
            <Button variant='outlined' onClick={()=> ToDoStatusHandler()} sx={{ marginTop: '16px' }}>
                Due in week
            </Button>
            <Button variant='outlined' onClick={()=> DoingStatusHandler()} sx={{ marginTop: '16px' }}>
                Due today
            </Button>
            <Button variant='outlined' onClick={()=> OverDueStatusHandler()} sx={{ marginTop: '16px' }}>
                OverDue
            </Button>
        </section>
    );
}
export default ChangeStatusForm;