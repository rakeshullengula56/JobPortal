import React, { useEffect, useState } from 'react';
import {
  AppBar,
  Toolbar,
  Box,
  Card,
  Grid,
  Typography,
  Container,
  Chip,
  Stack,
  CircularProgress,
} from "@mui/material";
import axios from "axios";

const Search = () => {
  const [posts, setPosts] = useState(null);

  useEffect(() => {
    const fetchInitialPosts = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/jobPosts`);
        setPosts(response.data);
      } catch (err) {
        setPosts([]);
      }
    };
    fetchInitialPosts();
  }, []);

  return (
    <Box sx={{ background: "#f6f8fa", minHeight: "100vh" }}>
      {/* Full-width, sticky header */}
      <AppBar position="sticky" color="primary" elevation={2}>
        <Toolbar>
          <Typography variant="h5" component="div" sx={{ flexGrow: 1, textAlign: 'center' }}>
            Job Portal
          </Typography>
        </Toolbar>
      </AppBar>

      {/* Main content container */}
      <Container sx={{ py: 4 }}>
        {!posts && (
          <Box sx={{ textAlign: "center", my: 8 }}>
            <CircularProgress color="primary" />
          </Box>
        )}
        {posts && posts.length === 0 && (
          <Typography align="center" color="text.secondary" sx={{ mt: 5, fontSize: "1.2rem" }}>
            No job posts found.
          </Typography>
        )}
        {posts && posts.length > 0 && (
          <Grid
            container
            spacing={3}
            justifyContent="center"
          >
            {posts.map((p) => (
              <Grid key={p.postId} item xs={12} sm={12} md={6} lg={4}>
                <Card
                  sx={{
                    p: 3,
                    borderRadius: 3,
                    minHeight: 320,
                    display: "flex",
                    flexDirection: "column",
                    boxShadow: "0 2px 12px rgba(60,60,120,0.10)",
                    background: "#fff"
                  }}
                  variant="outlined"
                >
                  <Typography variant="h6" sx={{ fontWeight: 700, color: "#35356b", mb: 1 }}>
                    {p.postProfile}
                  </Typography>

                  <Typography variant="body1" sx={{ color: "#484848", mb: 2 }}>
                    {p.postDesc}
                  </Typography>

                  <Typography variant="subtitle1" sx={{ fontWeight: 500, mb: 0.7 }}>
                    Years of Experience: <span style={{ color: "#646cff" }}>{p.reqExperience} years</span>
                  </Typography>

                  <Typography variant="subtitle2" gutterBottom sx={{ fontWeight: 600 }}>
                    Skills:
                  </Typography>
                  <Stack direction="row" spacing={1} sx={{ flexWrap: "wrap" }}>
                    {p.postTechStack.map((skill, i) => (
                      <Chip key={i} label={skill} color="primary" variant="outlined" size="small" />
                    ))}
                  </Stack>
                </Card>
              </Grid>
            ))}
          </Grid>
        )}
      </Container>
    </Box>
  );
};

export default Search;
