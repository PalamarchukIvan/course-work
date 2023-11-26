﻿import axios from 'axios';

const ARTICLES_REST = "http://localhost:8080/article-api";
const ADMIN_STAT_LINK_API = "http://localhost:8080/rest/admin-statistics";

class ArticleService {
    async getAllArticles() {
        return axios.get(
            ARTICLES_REST + "/",
            {
                withCredentials: true
            }
        );
    }
    async getSpecificArticle(id) {
        return axios.get(
            ARTICLES_REST + "/" + id,
            {
                withCredentials: true
            }
        );
    }
    doLike(id) {
        return axios.get(
            ARTICLES_REST + "/like/" + id,
            {
                withCredentials: true
            }
        );
    }    
    undoLike(id) {
        return axios.get(
            ARTICLES_REST + "/unlike/" + id,
            {
                withCredentials: true
            }
        );
    }
}

export default new ArticleService();