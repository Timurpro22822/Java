import React from 'react';
import logo from './logo.svg';
import './App.css';
import Navbar from './components/tailwind/Navbars';
import Pagination from './components/tailwind/Pagination';
import Home from './components/home';
import { Route, Routes } from 'react-router-dom';
import Team from './components/home/Team';
import NotFound from './components/home/NotFound';
import About from './components/home/About';
import Content from './components/home/Content';

function App() {
  return (
    <>

    <Navbar/>
    {/* <Pagination/> */}
    {/* <h1 className="text-3xl font-bold underline">Hello world!</h1> */}
    <main>
      <Routes>
        <Route path="/" element={<Home />}/>
        <Route path="/team" element={<Team />}/>
        <Route path="/content" element={<Content />}/>
        <Route path="/about" element={<About />}/>
        <Route path="*" element={<NotFound />}/>
      </Routes>
    </main>
  </>
  );
}

export default App;
