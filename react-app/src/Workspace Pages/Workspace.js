import React, { useEffect, useState } from 'react';
import ViewSpaces from '../Workspace Components/ViewSpaces';
import {useHistory} from "react-router-dom"

function WorkspacePage() {
    
    const [spacesData, setspacesData] = useState([]);
    let userIdVal = localStorage.getItem("userID");
    
    function getAllspaces() {
        fetch(`http://localhost:8080/workspace/user/${userIdVal}`,{
            method:'GET'
        })
        .then(response => response.json())
        .then(spaces => {
            setspacesData(spaces);
        });
    }

    useEffect(function () {
        getAllspaces();
    }, []);


    return (
        <section>
            <ViewSpaces spaces={spacesData} />
        </section>
    );
}

export default WorkspacePage;
