import React, { useEffect, useState } from 'react';
import Viewtasks from '../Task Components/Viewtasks';
import {useLocation} from "react-router-dom";

function TaskPage() {
    const [tasksData, settasksData] = useState([]);
    const location = useLocation();
    
    localStorage.setItem("BoardID", location.state.getTasksData);
    
    function getAlltasks() {
        fetch(`http://localhost:8080/board/tasks/${location.state.getTasksData}`,{
            method:'GET'
        })
        .then(response => response.json())
        .then(tasks => {
            settasksData(tasks);
        });
    }

    useEffect(function () {
        getAlltasks();
    }, []);


    return (
        <Viewtasks tasks={tasksData} />
    );
};

export default TaskPage;