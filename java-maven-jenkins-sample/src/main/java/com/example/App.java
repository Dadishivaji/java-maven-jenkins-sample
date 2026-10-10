package com.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Small Java web-page demo. It writes the HTML page to build/site/index.html.
 * This keeps the example beginner-friendly and dependency-free.
 */
public class App {
    public static void main(String[] args) throws IOException {
        Path output = Path.of("target", "site", "index.html");
        Files.createDirectories(output.getParent());
        Files.writeString(output, page(), StandardCharsets.UTF_8);
        System.out.println("Sample Java application generated: " + output.toAbsolutePath());
    }

    static String page() {
        return """
                <!doctype html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1">
                  <title>CloudDesk | Java Demo</title>
                  <style>
                    :root { --ink:#172033; --muted:#65708a; --blue:#315efb; --pale:#eef2ff; }
                    * { box-sizing:border-box; }
                    body { margin:0; font-family:Arial, sans-serif; color:var(--ink);
                           background:linear-gradient(135deg,#f5f7ff,#e8f7f4); }
                    .wrap { max-width:1000px; margin:0 auto; padding:48px 22px; }
                    nav { display:flex; justify-content:space-between; align-items:center; gap:16px; }
                    .brand { font-weight:800; letter-spacing:.4px; }
                    .pill { background:white; border:1px solid #dfe5f5; padding:9px 14px;
                            border-radius:999px; color:var(--muted); font-size:13px; }
                    .hero { padding:70px 0 42px; display:grid; grid-template-columns:1.3fr .7fr;
                            gap:32px; align-items:center; }
                    h1 { font-size:clamp(38px,6vw,64px); line-height:1.03; margin:14px 0; }
                    p { color:var(--muted); line-height:1.7; }
                    .eyebrow { color:var(--blue); font-weight:700; text-transform:uppercase;
                               letter-spacing:1.5px; font-size:12px; }
                    .button { display:inline-block; margin-top:14px; background:var(--blue); color:white;
                              text-decoration:none; padding:13px 18px; border-radius:12px; font-weight:700; }
                    .panel { background:white; border:1px solid #e6eaf5; border-radius:22px;
                             padding:26px; box-shadow:0 18px 55px #243b6b12; }
                    .metric { display:flex; justify-content:space-between; padding:14px 0;
                              border-bottom:1px solid #edf0f7; }
                    .metric:last-child { border:0; }
                    .metric strong { color:var(--blue); }
                    .cards { display:grid; grid-template-columns:repeat(3,1fr); gap:16px; }
                    .card { background:#ffffffc9; border:1px solid #e2e8f4; border-radius:18px; padding:20px; }
                    .card h3 { margin-top:0; }
                    footer { padding-top:38px; color:var(--muted); font-size:13px; }
                    @media (max-width:700px) { .hero { grid-template-columns:1fr; padding-top:42px; }
                      .cards { grid-template-columns:1fr; } }
                  </style>
                </head>
                <body>
                  <main class="wrap">
                    <nav><div class="brand">☁ CloudDesk</div><span class="pill">Java + Maven + Jenkins</span></nav>
                    <section class="hero">
                      <div>
                        <div class="eyebrow">Sample CI/CD project</div>
                        <h1>Build better.<br>Ship confidently.</h1>
                        <p>A simple Java application with a responsive HTML/CSS landing page.
                           Use Maven to build and test it, then Jenkins Declarative Pipeline to automate the workflow.</p>
                        <a class="button" href="#features">Explore the project →</a>
                      </div>
                      <aside class="panel">
                        <div class="eyebrow">Build overview</div>
                        <h2>Project health</h2>
                        <div class="metric"><span>Language</span><strong>Java 21</strong></div>
                        <div class="metric"><span>Build tool</span><strong>Maven</strong></div>
                        <div class="metric"><span>Automation</span><strong>Jenkins</strong></div>
                        <div class="metric"><span>Page status</span><strong>Ready</strong></div>
                      </aside>
                    </section>
                    <section id="features" class="cards">
                      <article class="card"><h3>☕ Java</h3><p>Runs the application entry point and generates the HTML page.</p></article>
                      <article class="card"><h3>🎨 HTML & CSS</h3><p>A clean, responsive interface with cards, metrics, and a modern layout.</p></article>
                      <article class="card"><h3>⚙ CI pipeline</h3><p>Jenkins checks out source, runs tests, packages the JAR, and archives artifacts.</p></article>
                    </section>
                    <footer>Demo project for learning Java, Maven, Git, and Jenkins. Customize it for your own portfolio.</footer>
                  </main>
                </body>
                </html>
                """;
    }
}
