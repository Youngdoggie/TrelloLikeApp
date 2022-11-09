import React, { useEffect, useState } from 'react';
import {useLocation} from "react-router-dom";
import ViewDueToday from '../Task Components/ViewDueToday';

function DueToday() {
    const [tasksData, settasksData] = useState([]);
    
    let boardIdVal = localStorage.getItem("BoardID");
    
    function getDueToday() {
        fetch(`http://localhost:8080/board/tasks/1/${boardIdVal}`,{
            method:'GET'
        })
        .then(response => response.json())
        .then(tasks => {
            settasksData(tasks);
        });
    }

    useEffect(function () {
        getDueToday();
    }, []);


    return (
        <ViewDueToday tasks={tasksData} />
    );
};

export default DueToday;