import React, { Component } from 'react';
import { Button, Card } from 'react-bootstrap';
import ArticleService from "../services/ArticleService";
import UserService from "../services/UserService";
import {Link} from "react-router-dom";

class SingleArticleComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            currentUserId: '',
            article: {
                id: '',
                header: '',
                body: '',
                likes: [
                    {
                        id: '',
                        username: '',
                        name: '',
                        password: '',
                        photoBytes: '',
                        articleIds: [],
                        role: [],
                    }
                ],
                createdDate: '',
                author: {
                    id: '',
                    username: '',
                    name: '',
                    password: '',
                    photoBytes: '',
                    articleIds: [],
                    role: [],
                }
            }
        }
    }
    doLike = () => {
        if(this.state.article.likes.map(author => author.id).includes(this.state.currentUserId)) {
            ArticleService.undoLike(this.state.article.id).then(res => {
                if (res.config !== null && res.request != null && res.config.url !== res.request.responseURL && res.request.responseURL.includes('/login')) {
                    console.log(res);
                    document.location = res.request.responseURL;
                } else {
                    console.log(res);
                    console.log('data => ' + res.data);
                    this.getArticle()
                }
            })
        } else {
            ArticleService.doLike(this.state.article.id).then(res => {
                if (res.config !== null && res.request != null && res.config.url !== res.request.responseURL && res.request.responseURL.includes('/login')) {
                    console.log(res);
                    document.location = res.request.responseURL;
                } else {
                    console.log(res);
                    console.log('data => ' + res.data);
                    this.getArticle()
                }
            })
        }
    } 
    componentDidMount() {
        this.getArticle()
    }
    getArticle() {
        ArticleService.getSpecificArticle(this.props.match.params.id).then((res) => {
            if (res.config !== null && res.request != null && res.config.url !== res.request.responseURL && res.request.responseURL.includes('/login')) {
                console.log(res);
                document.location = res.request.responseURL;
            } else {
                console.log(res);
                console.log('data => ' + res.data);
                this.setState({
                    article: res.data,
                });
                UserService.getCurrentUser().then(res => {
                        console.log("user data")
                        console.log(res.data)
                        this.setState({
                            currentUserId: res.data.id
                        })
                        console.log("id")
                        console.log(this.state.currentUserId)
                })
            }
        })

    }

    render() {
        const isLiked = this.state.article.likes.map(author => author.id).includes(this.state.currentUserId)
        const LikeButtonColor = isLiked ? 'danger' : 'success';
        const LikeButtonText = isLiked ? 'Unlike' : 'Lke';
        return (
            <div>
                <h1 style={{color: "#05386B"}}>{this.state.article.header}</h1>
                <Card className="mb-3">
                    <Card.Body>
                        <Card.Subtitle className="mb-2 text-muted">
                            Author: {this.state.article.author.name == null ? "Anonimus" : this.state.article.author.name}
                        </Card.Subtitle>
                        <Card.Text>{this.state.article.body}</Card.Text>
                        <Button variant={LikeButtonColor} className="mr-2" onClick={this.doLike}>
                            {LikeButtonText} ({this.state.article.likes.length})
                        </Button>
                        <br />
                        <br />
                        <a href="/articles" className="btn btn-primary text-white" style={{backgroundColor: "#05386B", textDecoration: 'none' }} > {'<- Back'}</a>
                    </Card.Body>
                </Card>
            </div>
        );
    }
}

export default SingleArticleComponent;