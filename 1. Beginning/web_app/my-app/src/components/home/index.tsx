import axios from "axios";
import { useEffect } from "react";
import { useDispatch } from "react-redux";
import { useSelector } from "react-redux";
import { Link } from "react-router-dom";
import { APP_ENV } from "../../env";
import { CategoryActionTypes, ICategoryItem } from "../../types";



const Home = () => {

  return (
    <h1 className="align-center">This is the home page!</h1>
  )

}
export default Home;