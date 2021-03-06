/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ajoberstar.gradle.git.publish

import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.file.CopySpec
import org.gradle.api.tasks.util.PatternFilterable
import org.gradle.api.tasks.util.PatternSet

class GitPublishExtension {
  String repoUri

  String branch

  File repoDir

  final CopySpec contents

  final PatternFilterable preserve

  /**
   * The message used when committing changes.
   * Defaults to 'Publish of Github pages from Gradle.'.
   */
  String commitMessage = 'Generated by gradle-git-publish'

  public GitPublishExtension(Project project) {
    contents = project.copySpec()
    preserve = new PatternSet()
    preserve.include('.git')
  }

  void contents(Action<? super CopySpec> action) {
    action.execute(contents)
  }

  void preserve(Action<? super PatternFilterable> action) {
    action.execute(preserve)
  }
}
