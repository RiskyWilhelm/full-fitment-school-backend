package com.students.risky.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping
@ApiIgnore
public class MainController {

    @GetMapping
    public String returnError(){
        return """
                <style>
                *{
                 padding:0; margin: 0;
                }
                li{
                 margin: 0 auto;
                }
                 .waviy {
                   position: relative;
                   -webkit-box-reflect: below -20px linear-gradient(transparent, rgba(0,0,0,.2));
                   font-size: 60px;
                 }
                 .waviy span {
                   position: relative;
                   display: inline-block;
                   color: #fff;
                   animation: waviy calc(1.2s * var(--i)) infinite;
                   animation-delay: calc(.2s * var(--i));
                 }
                 @keyframes waviy {
                   0%,40%,100% {
                     transform: translateY(0)
                   }
                   20% {
                     transform: translateY(-20px)
                   }
                </style>
                <div style="display: flex; width:100vw; height: 100vh; align-items:center; flex-direction: column; justify-content: center; font-size: 2em; color:white; background-color: black;">
                <div class="waviy">
                <a style="text-decoration: none; color:white;" href="swagger-ui/">
                <span style="--i:1">C</span>
                <span style="--i:2">l</span>
                <span style="--i:3">i</span>
                <span style="--i:4">c</span>
                <span style="--i:5">k</span>
                &nbsp;
                <span style="--i:6">H</span>
                <span style="--i:7">e</span>
                <span style="--i:8">r</span>
                <span style="--i:9">e</span>
                &nbsp;
                <span style="--i:10">t</span>
                <span style="--i:11">o</span>
                &nbsp;
                <span style="--i:12">C</span>
                <span style="--i:13">o</span>
                <span style="--i:14">n</span>
                <span style="--i:15">t</span>
                <span style="--i:16">i</span>
                <span style="--i:17">n</span>
                <span style="--i:18">u</span>
                <span style="--i:19">e</span>
                &nbsp;
                <span style="--i:20">/</span>
                <span style="--i:21">s</span>
                <span style="--i:22">w</span>
                <span style="--i:23">a</span>
                <span style="--i:24">g</span>
                <span style="--i:25">g</span>
                <span style="--i:26">e</span>
                <span style="--i:27">r</span>
                <span style="--i:28">-</span>
                <span style="--i:29">u</span>
                <span style="--i:30">i</span>
                </a>
                </div>
                <div style="display: block; position:relative;">
                <ul style="list-style-type: none; display: grid;">
                <li>Used: <span style="color: orange;">PostgreSQL</span></li>
                <li>Database Name: <span style="color: orange;">studentsdata</span></li>
                <li>Used Port: localhost:<span style="color: orange;">5432</span>/</li>
                </ul>
                </div>
                
                </div>
                 """;
    }
}
