import React, { useEffect, useState } from 'react';
import {useLocation} from "react-router-dom";
import ViewOverDue from '../Task Components/ViewOverDue';

function OverDue() {
    const [tasksData, settasksData] = useState([]);
    
    let boardIdVal = localStorage.getItem("BoardID");
    
    function getoverDue() {
        fetch(`http://localhost:8080/board/tasks/2/${boardIdVal}`,{
            method:'GET'
        })
        .then(response => response.json())
        .then(tasks => {
            settasksData(tasks);
        });
    }

    useEffect(function () {
        getoverDue();
    }, []);


    return (
        <ViewOverDue tasks={tasksData} />
    );
};

export default OverDue;