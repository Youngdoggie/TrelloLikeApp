import React, { useEffect, useState } from 'react';
import {useLocation} from "react-router-dom";
import ViewDueInWeek from '../Task Components/ViewDueInWeek'

function DueInWeekPage() {
    const [tasksData, settasksData] = useState([]);
    
    let boardIdVal = localStorage.getItem("BoardID");
    
    function getDueInWeek() {
        fetch(`http://localhost:8080/board/tasks/0/${boardIdVal}`,{
            method:'GET'
        })
        .then(response => response.json())
        .then(tasks => {
            settasksData(tasks);
        });
    }

    useEffect(function () {
        getDueInWeek();
    }, []);


    return (
        <ViewDueInWeek tasks={tasksData} />
    );
};

export default DueInWeekPage;