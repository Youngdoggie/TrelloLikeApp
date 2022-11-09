import React, {useRef} from "react";
import { useEffect, useState } from 'react';
import Viewtasks from '../Task Components/Viewtasks';
import {useLocation} from "react-router-dom";
import SearchForm from '../Task Components/SearchForm';

function SearchPage(keyWord){
    const [searchData, setsearchData] = useState([]);
    let boardIdVal = localStorage.getItem("BoardID");

    function getAllresult(data) {
        fetch(`http://localhost:8080/board/tasks/${boardIdVal}`,{
            method:'GET'
        })
        .then(response => response.json())
        .then(result => {
            setsearchData(result);
        });
    }

    useEffect(function () {
        getAllresult();
    }, []);

    return(
        <div class="text-center margin5">
            <SearchForm result= {searchData}/>
        </div>
    );
};

export default SearchPage;