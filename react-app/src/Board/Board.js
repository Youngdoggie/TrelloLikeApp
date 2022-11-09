import React, { useEffect, useState } from 'react';
import ViewBoards from '../Board Components/ViewBoards';
import { useLocation } from 'react-router-dom';
import {useHistory} from "react-router-dom"

function Boards() {
    const [boardsData, setBoardsData] = useState([]);
    const location = useLocation();

    localStorage.setItem("workspaceID", location.state.data);

    function getAllBoards() {
        fetch(`http://localhost:8080/workspace/${location.state.data}`,{
            method:'GET'
        })
        .then(response => response.json())
        .then(boards => {
            setBoardsData(boards);
        });
    };

    useEffect(function () {
        getAllBoards();
    }, []);


    return (
        <section>
            <ViewBoards boards={boardsData} />
        </section>
    );
};

export default Boards;
